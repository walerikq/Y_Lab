package com.company.ThirdLesson.OrgStructurePack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrgStructureParserImpl implements OrgStructureParser {

    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        Map<Long, Employee> employees = new HashMap<>();
        boolean isFirstLine = true;

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(";");
                Long id = Long.parseLong(fields[0]);
                Long bossId = fields[1].isEmpty() ? null : Long.parseLong(fields[1]);
                String name = fields[2];
                String position = fields[3];
                Employee employee = employees.get(id);
                if (employee == null) {
                    employee = new Employee();
                    employee.setId(id);
                    employees.put(id, employee);
                }
                employee.setBossId(bossId);
                employee.setName(name);
                employee.setPosition(position);
                if (bossId != null) {
                    Employee boss = employees.get(bossId);
                    if (boss == null) {
                        boss = new Employee();
                        boss.setId(bossId);
                        employees.put(bossId, boss);
                    }
                    employee.setBoss(boss);
                    boss.getSubordinate().add(employee);
                }
            }
        }

        for (Employee employee : employees.values()) {
            if (employee.getBossId() == null) {
                return employee;
            }
        }
        return null;
    }
}
