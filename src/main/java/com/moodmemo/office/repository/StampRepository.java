package com.moodmemo.office.repository;

import com.moodmemo.office.domain.Stamps;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

// create config for mongodb
// https://www.baeldung.com/spring-data-mongodb-tutorial


public interface StampRepository extends MongoRepository<Stamps, String> {

    // please create method find by kakaoId and between dateTime sort by dateTime
    List<Stamps> findByKakaoIdAndDateTimeBetweenOrderByDateTime(
            String kakaoId,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime);

//    Optional<Stamps> findByKakaoIdAndLocalTimeAndLocalDate(String kakaoId,
//                                                           LocalTime localTime,
//                                                           LocalDate localDate);

    int countByKakaoIdAndDateTimeBetween(String kakaoId,
                                         LocalDateTime startDateTime,
                                         LocalDateTime endDateTime);

    List<Stamps> findByKakaoIdAndDateTimeBetween(String kakaoId,
                                                 LocalDateTime startDateTime,
                                                 LocalDateTime endDateTime);
}
