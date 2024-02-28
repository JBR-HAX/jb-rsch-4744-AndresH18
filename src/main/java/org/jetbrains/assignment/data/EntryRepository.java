package org.jetbrains.assignment.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<DbEntry, Integer> {
}
