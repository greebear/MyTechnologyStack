package com.greebear.algorithm.leetcodeSubject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class N690_getImportance
{
    int total=0;
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for(Employee employee:employees){
            map.put(employee.id, employee);
        }
        total = dfs(map.get(id));
        return total;
    }

    public int dfs(Employee employee)
    {
        if(employee.subordinates==null) return employee.importance;
        for(Integer i: employee.subordinates){
            total += dfs(map.get(i));
        }
        total += employee.importance;
        return total;
    }
}
