/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokoweb.tokowebspringvue.controller;

import com.tokoweb.tokowebspringvue.entity.Item;
import com.tokoweb.tokowebspringvue.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ustadho
 */
@RestController
@RequestMapping("api/master/item")
public class ItemController {
    @Autowired
    ItemRepository repository;
    
    @GetMapping
    public Page<Item> findByPage(Pageable pg){
        return repository.findAll(pg);
    }
    
    @GetMapping("all")
    public Iterable<Item> findAll(){
        return repository.findAll();
    }
    
    @PostMapping
    public Item insert(@RequestBody Item i){
        if(i.getId()!=null){
            return update(i);
        }
        return repository.save(i);
    }
    
    @PutMapping
    public Item update(@RequestBody Item i){
        return repository.save(i);
    }
    
    @DeleteMapping("{id}")
    public void delet(@PathVariable Integer id){
        repository.delete(id);
    }
    
}
