package com.example.basicauth;

public enum ApplicationPermission {
    STUDENT_WRITE("student:write"),
    STUDENT_READ("student:read"),
    COURSE_WRITE("course:write"),
    COURSE_READ("course:read");
    private final String permission;

    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissions() {
        return permission;
    }


}
