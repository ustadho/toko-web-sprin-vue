/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokoweb.tokowebspringvue.controller;

import com.tokoweb.tokowebspringvue.entity.KategoriItem;
import com.tokoweb.tokowebspringvue.repository.KategoriItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ustadho
 */
@RestController
@RequestMapping("api/master/kategori-item")
public class KategoriItemController {
    @Autowired
    KategoriItemRepository repository;
    
    @GetMapping("all")
    public Iterable<KategoriItem> findAll(){
        return repository.findAll();
    }
    
}
