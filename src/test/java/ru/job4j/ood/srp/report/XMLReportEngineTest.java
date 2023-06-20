package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;

class XMLReportEngineTest {

    @Test
    public void whenOneEmployeeThenReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 50_000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new XMLReportEngine(store, parser);
        String date = parser.parse(now);
        String expect = String.format("""
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>Ivan</name>
                        <hired>%s</hired>
                        <fired>%s</fired>
                        <salary>50000.0</salary>
                    </employee>
                </employees>
                """,
                date, date);
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
        Report engine = new XMLReportEngine(store, parser);
        String date = parser.parse(now);
        String expect = String.format("""
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <name>Ivan</name>
                        <hired>%s</hired>
                        <fired>%s</fired>
                        <salary>50000.0</salary>
                    </employee>
                    <employee>
                        <name>Andrey</name>
                        <hired>%s</hired>
                        <fired>%s</fired>
                        <salary>60000.0</salary>
                    </employee>
                    <employee>
                        <name>Petr</name>
                        <hired>%s</hired>
                        <fired>%s</fired>
                        <salary>65000.0</salary>
                    </employee>
                </employees>
                """,
                date, date, date, date, date, date);
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}