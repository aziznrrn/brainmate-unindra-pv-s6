/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brainmateapp.model;

/**
 *
 * @author BMPC2024-8
 */
public class Marketing {
    private int id;
    private String name;
    private String area;
    private String email;

    public Marketing() {
    }

    public Marketing(int id, String name, String area, String email) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

