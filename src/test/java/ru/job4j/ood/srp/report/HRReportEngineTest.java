package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.*;

class HRReportEngineTest {

    @Test
    public void whenThreeEmployeeThenReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 50_000);
        Employee worker2 = new Employee("Andrey", now, now, 60_000);
        Employee worker3 = new Employee("Petr", now, now, 65_000);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary);
        Report engine = new HRReportEngine(store, comparator);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(" ")
                .append(worker3.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenOneEmployeeThenReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 50_000);
        store.add(worker);
        Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary);
        Report engine = new HRReportEngine(store, comparator);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

    @Test
    public void whenNoEmployees() {
        MemStore store = new MemStore();
        Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary);
        Report engine = new HRReportEngine(store, comparator);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}