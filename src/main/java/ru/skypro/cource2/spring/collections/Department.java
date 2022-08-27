package ru.skypro.cource2.spring.collections;

import java.util.Objects;

public class Department {
    private final int departmentNum;

    public Department(int departmentNum) {
        this.departmentNum = departmentNum;
    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Integer) {
            return o.equals(departmentNum);
        }
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return departmentNum == that.departmentNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentNum);
    }

    @Override
    public String toString() {
        return String.format(
                "Отдел №%s",
                departmentNum
        );
    }
}
