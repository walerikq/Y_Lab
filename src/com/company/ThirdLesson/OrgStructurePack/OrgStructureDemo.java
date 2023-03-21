package com.company.ThirdLesson.OrgStructurePack;

import java.io.File;
import java.io.IOException;

public class OrgStructureDemo {
    public static void main(String[] args) throws IOException {

        OrgStructureParserImpl orgStructureParser = new OrgStructureParserImpl();
        Employee headOfStaff = orgStructureParser.parseStructure(new File("D:\\Downloads\\CSV.txt"));
        System.out.println(headOfStaff);
    }
}
