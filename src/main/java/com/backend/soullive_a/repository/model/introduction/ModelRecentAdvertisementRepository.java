package com.backend.soullive_a.repository.model.introduction;


import com.backend.soullive_a.entity.model.Model;

import com.backend.soullive_a.entity.model.introduction.ModelRecentAdvertisement;
import com.backend.soullive_a.entity.model.introduction.ModelRecentWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRecentAdvertisementRepository extends JpaRepository<ModelRecentAdvertisement, Long> {

    public List<ModelRecentAdvertisement> findAllByModel(Model model);

}

