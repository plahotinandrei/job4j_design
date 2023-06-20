package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JSONReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public JSONReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<JSONObject> jsonEmployees = store.findBy(filter).stream()
                .map((employee) -> {
                    JSONObject jsonEmployee = new JSONObject();
                    jsonEmployee.put("name", employee.getName());
                    jsonEmployee.put("hired", dateTimeParser.parse(employee.getHired()));
                    jsonEmployee.put("fired", dateTimeParser.parse(employee.getFired()));
                    jsonEmployee.put("salary", employee.getSalary());
                    return jsonEmployee;
                }).toList();
        return new JSONArray(jsonEmployees).toString(4);
    }
}
