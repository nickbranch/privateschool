/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.LocalDateTime;

public class Assignment {

    private String title;
    private String description;
    private LocalDateTime subDateTime;
    private LocalDateTime dateOfSub;
    private int oralMark;
    private int totalMark;

    public Assignment() {

    }

    public Assignment(String title, String description, LocalDateTime subDateTime) { // Random constructor
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = 40;
        this.totalMark = 100;
        this.dateOfSub = subDateTime;
    }

    public Assignment(String title, String description, LocalDateTime subDateTime, int oralMark, int totalMark) { // Random manual copy
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = 40;
        this.totalMark = 100;
        this.dateOfSub = subDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDateTime subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public LocalDateTime getDateOfSub() {
        return dateOfSub;
    }

    public void setDateOfSub(LocalDateTime dateOfSub) {
        this.dateOfSub = dateOfSub;
    }
}
