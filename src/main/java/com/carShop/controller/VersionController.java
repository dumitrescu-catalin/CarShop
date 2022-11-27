package com.carShop.controller;

import com.carShop.exception.ResourceNotFoundException;
import com.carShop.model.Version;
import com.carShop.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/versions")     //localhost:8080/api/versions
public class VersionController {

    private final VersionService versionService;

    //GET
    @GetMapping("/allVersions")      //localhost:8080/api/versions/allVersions
    public ResponseEntity<List<Version>> getAllVersions() {
        List<Version> versionList = versionService.readAllVersion();
        if (versionList.size() == 0) {
            throw new ResourceNotFoundException("There are no versions in the database");
        }
        return ResponseEntity.ok(versionList);
    }

    @GetMapping("/getVersionById/{id}")     //localhost:8080/api/versions/getVersionById/
    public ResponseEntity<Version> getVersionById(@PathVariable int id) {
        Version version = versionService.readAllVersionById(id).orElseThrow(() -> new ResourceNotFoundException("There are no version with id: " + id + " in DB!"));
        return ResponseEntity.ok(version);
    }

    @GetMapping("/getVersionsByName")       //localhost:8080/api/versions/getVersionsByName?name=
    public ResponseEntity<List<Version>> getVersionByName(@RequestParam(value = "name") String name) {
        List<Version> versionList = versionService.readAllVersionByName(name);
        if (versionList.size() == 0) {
            throw new ResourceNotFoundException("Version with name:  " + name + " not found!");
        }
        return ResponseEntity.ok(versionList);
    }

    //POST
    @PostMapping("/addNewVersion")      //localhost:8080/api/versions/addNewVersion
    public ResponseEntity<Version> addNewVersion(@RequestBody Version version) {
        Version version1 = versionService.addVersion(version);
        return ResponseEntity.ok(version1);
    }

    //PUT
    @PutMapping("/updateVersion")       //localhost:8080/api/versions/updateVersion
    public ResponseEntity<Version> updateVersion(@RequestBody Version version) {
        Version editVersion = versionService.editVersion(version);
        return ResponseEntity.ok(editVersion);
    }

    //DELETE
    @DeleteMapping("/deleteVersionById/{id}")    //localhost:8080/api/versions/deleteVersionById
    public ResponseEntity<?> deleteVersion(@PathVariable int id){
        versionService.readAllVersionById(id).orElseThrow(()-> new ResourceNotFoundException("There are no version with id: " + id + " in DB!"));
        versionService.deleteVersionById(id);

        return new ResponseEntity<>("Product with id: " + id + " deleted successfully!", HttpStatus.OK);
    }

}
