package com.backend.ecotask.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeCheckDto {

    @Getter
    @Setter
    @ToString
    public static class NowInfoRes {
        private Integer employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private LocalDate hireDate;
        private JobsDto jobs;
        private BigDecimal salary;
        private BigDecimal commissionPct;
        private ManagerDto manager;
        private DepartmentsDto departments;

        @Getter
        @Setter
        public static class JobsDto {
            private String jobId;
            private String jobTitle;
            private BigDecimal minSalary;
            private BigDecimal maxSalary;
        }

        @Getter
        @Setter
        public static class ManagerDto {
            private Integer employeeId;
            private String firstName;
            private String lastName;
        }

        @Getter
        @Setter
        public static class DepartmentsDto {
            private Integer departmentId;
            private String departmentName;
            private ManagerDto manager;
            private LocationDto locations;

            @Getter
            @Setter
            public static class LocationDto {
                private Integer locationId;
                private String streetAddress;
                private String postalCode;
                private String city;
                private String stateProvince;
                private CountryDto countries;

                @Getter
                @Setter
                public static class CountryDto {
                    private String countryId;
                    private String countryName;
                    private RegionsDto region;

                    @Getter
                    @Setter
                    public static class RegionsDto {
                        private Integer regionId;
                        private String regionName;
                    }
                }
            }
        }
    }

    @Getter
    @Setter
    public static class HistoryInfoRes {

    }

}
