package com.macropay.msapp.entity;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Integer id;
    
    @JsonProperty("icon")
    @Getter
    @Setter
    @Column(name="icon")
    private String icon;
    
    @JsonProperty("key_menu")
    @Getter
    @Setter
    @Column(name="key_menu")
    private String keyMenu;
    
    @JsonProperty("link")
    @Getter
    @Setter
    @Column(name="link")
    private String link;
    
    @JsonProperty("order")
    @Getter
    @Setter
    @Column(name="order_menu")
    private Integer orderMenu;
    
    @JsonProperty("parent_id")
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Menu parent;
    
    @JsonProperty("title")
    @Getter
    @Setter
    @Column(name="title")
    private String title;
    
    @JsonProperty("type_menu")
    @Getter
    @Setter
    @Column(name="type_menu")
    private String typeMenu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    @JsonProperty(value = "children", access = JsonProperty.Access.WRITE_ONLY)
    @Setter
    @OrderBy("orderMenu ASC")
    private Set<Menu> children;

    @JsonIgnore
    public Set<Menu> getChildren() {
        return children;
    }
    
    @PrePersist
    private void beforeSave() {
        if(!Objects.isNull(this.children)) {
            System.out.println("this title: "+this.getTitle());
            this.children.forEach(child -> child.setParent(this));
        }
    }
 
}
