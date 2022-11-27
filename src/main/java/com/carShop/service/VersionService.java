package com.carShop.service;

import com.carShop.model.Version;
import com.carShop.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionService {
    @Autowired
    VersionRepository versionRepository;

    //GET
    public List<Version> readAllVersion() {
        return versionRepository.findAll();
    }

    public List<Version> readAllVersionByName(String name) {
        return versionRepository.getVersionByName(name);
    }

    public Optional<Version> readAllVersionById(int id) {
        return versionRepository.findById(id);
    }

    //POST
    public Version addVersion(Version version) {
        return versionRepository.save(version);
    }

    //PUT
    public Version editVersion(Version version) {
        return versionRepository.save(version);
    }

    //DELETE
    public void deleteVersionById(int id) {
        versionRepository.deleteById(id);
    }
}
