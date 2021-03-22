/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.HobbyEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zarpy
 */
    public class HobbyDTO {
        private long id;
        private String name;
        private String wikiLink;
        private String category;
        private String type;
    
    public HobbyDTO(String name, String wikiLink, String category, String type) {
        this.name = name;
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
    }

        public static List<HobbyDTO> getDtos(List<HobbyEntity> rms){
        List<HobbyDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new HobbyDTO(rm)));
        return rmdtos;
    }


    public HobbyDTO(HobbyEntity rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.wikiLink = rm.getWikiLink();
        this.category = rm.getCategory();
        this.type = rm.getType();
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
