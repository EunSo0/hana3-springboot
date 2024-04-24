package com.study.springboot.one2one;

import org.springframework.data.jpa.repository.JpaRepository;

public interface One2OneRepository extends JpaRepository<One2One,Long> {
}
