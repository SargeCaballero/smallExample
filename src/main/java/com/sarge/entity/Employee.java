package com.sarge.entity;

public class Employee extends Person {

    private double wage;

    private Employee(String name, String surname, int age, String gender, double wage) {
        super(name, surname, age, gender);
        this.wage = wage;
    }
    public double getWage() {
        return wage;
    }
    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        if (!super.equals(o)) return false;

        return Double.compare(wage, employee.wage) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(wage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static class EmployeeBuilder extends PersonBuilder {

        protected double wage;

        public EmployeeBuilder(String name, String surname) {
            super(name, surname);
        }

        @Override
        public EmployeeBuilder age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public EmployeeBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder wage(double wage) {
            this.wage = wage;
            return this;
        }

        @Override
        public Employee build() {
            return new Employee(name, surname, age, gender, wage);
        }
    }
}
