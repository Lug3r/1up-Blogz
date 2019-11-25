package org.launchcode.models.data;


import org.launchcode.models.Preference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PreferenceDao extends CrudRepository<Preference, Integer> {
}
