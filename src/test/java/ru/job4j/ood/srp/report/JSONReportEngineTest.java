package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;

class JSONReportEngineTest {

    @Test
    public void whenOneEmployeeThenReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 50_000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new JSONReportEngine(store, parser);
        String date = parser.parse(now);
        String expect = String.format("""
                [{
                    "fired": "%s",
                    "name": "Ivan",
                    "hired": "%s",
                    "salary": 50000
                }]""", date, date);
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }

    @Test
    public void whenThreeEmployeeThenReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 50_000);
        Employee worker2 = new Employee("Andrey", now, now, 60_000);
        Employee worker3 = new Employee("Petr", now, now, 65_000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new JSONReportEngine(store, parser);
        String date = parser.parse(now);
        String expect = String.format("""
                [
                    {
                        "fired": "%s",
                        "name": "Ivan",
                        "hired": "%s",
                        "salary": 50000
                    },
                    {
                        "fired": "%s",
                        "name": "Andrey",
                        "hired": "%s",
                        "salary": 60000
                    },
                    {
                        "fired": "%s",
                        "name": "Petr",
                        "hired": "%s",
                        "salary": 65000
                    }
                ]""", date, date, date, date, date, date);
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}