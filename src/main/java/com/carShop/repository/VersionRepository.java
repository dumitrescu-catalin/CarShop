package com.carShop.repository;

import com.carShop.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<Version, Integer> {
    List<Version> getVersionByName(String name);
}
