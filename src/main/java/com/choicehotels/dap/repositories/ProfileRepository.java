package com.choicehotels.dap.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.choicehotels.dap.dto.ProfileDTO;

public interface ProfileRepository extends JpaRepository<ProfileDTO, Long>{

}
