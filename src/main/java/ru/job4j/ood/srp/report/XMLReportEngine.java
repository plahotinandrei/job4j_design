package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class XMLReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private Marshaller marshaller;

    public XMLReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeeDTO.class, EmployeesDTO.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        if (marshaller != null) {
            try (StringWriter writer = new StringWriter()) {
                List<EmployeeDTO> employees = store.findBy(filter).stream()
                        .map((employee) -> new EmployeeDTO(
                                employee.getName(),
                                dateTimeParser.parse(employee.getHired()),
                                dateTimeParser.parse(employee.getFired()),
                                employee.getSalary()
                        ))
                        .toList();
                marshaller.marshal(new EmployeesDTO(employees), writer);
                xml = writer.getBuffer().toString();
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
        }
        return xml;
    }

    @XmlRootElement(name = "employees")
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class EmployeesDTO {

        @XmlElement(name = "employee")
        private List<EmployeeDTO> employees;

        public EmployeesDTO() {

        }

        public EmployeesDTO(List<EmployeeDTO> employees) {
            this.employees = employees;
        }
    }

    @XmlRootElement(name = "employee")
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class EmployeeDTO {

        @XmlElement(name = "name")
        private String name;

        @XmlElement(name = "hired")
        private String hired;

        @XmlElement(name = "fired")
        private String fired;

        @XmlElement(name = "salary")
        private double salary;

        public EmployeeDTO() {

        }

        public EmployeeDTO(String name, String hired, String fired, double salary) {
            this.name = name;
            this.hired = hired;
            this.fired = fired;
            this.salary = salary;
        }
    }
}
