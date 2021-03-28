package com.abc.monster.pojo;

/**
 * 打字区域表
 */
public class Typingarea
{
    private int typ_id;
    private String typ_name;
    private String typ_content;

    public Typingarea() {
    }

    public Typingarea(int typ_id, String typ_name, String typ_content) {
        this.typ_id = typ_id;
        this.typ_name = typ_name;
        this.typ_content = typ_content;
    }

    public int getTyp_id() {
        return typ_id;
    }

    public void setTyp_id(int typ_id) {
        this.typ_id = typ_id;
    }

    public String getTyp_name() {
        return typ_name;
    }

    public void setTyp_name(String typ_name) {
        this.typ_name = typ_name;
    }

    public String getTyp_content() {
        return typ_content;
    }

    public void setTyp_content(String typ_content) {
        this.typ_content = typ_content;
    }


}
