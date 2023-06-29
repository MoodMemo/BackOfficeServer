package com.moodmemo.office.controller;

import com.moodmemo.office.dto.StampDto;
import com.moodmemo.office.dto.UserDto;
import com.moodmemo.office.service.KakaoService;
import com.moodmemo.office.service.StampService;
import com.moodmemo.office.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.moodmemo.office.code.EventCode.WEEK1;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class DummyController {

    private final UserService userService;
    private final StampService stampService;
    private final KakaoService kakaoService;

    @PostMapping("/add-user")
    public UserDto.Response createUser(@Valid @RequestBody UserDto.Dummy request) {
        return userService.createUser(request);
    }

    @PostMapping("/add-stamp")
    public StampDto.Response createStamp(@Valid @RequestBody StampDto.Dummy request) {
        return stampService.createStamp(request);
    }

    @GetMapping("/tmp")
    public void tmp() {
        LocalDate tmp1 = LocalDate.of(2023, 6, 23);
        LocalDate tmp2 = LocalDate.of(2023, 6, 29);
        LocalDate tmp3 = LocalDate.of(2023, 6, 25);
        if (tmp1.isAfter(WEEK1.getStartDate()) && tmp1.isBefore(WEEK1.getEndDate()))
            log.info("tmp1: {}", tmp1);
        if (tmp2.isAfter(WEEK1.getStartDate()) && tmp2.isBefore(WEEK1.getEndDate()))
            log.info("tmp2: {}", tmp2);
        if (tmp3.isAfter(WEEK1.getStartDate()) && tmp3.isBefore(WEEK1.getEndDate()))
            log.info("tmp3: {}", tmp3);

    }

    @PostMapping("/validate/validateStampByTimeAPI") // 테스트 완료
    public HashMap<String, Object> validateStampByTimeAPI(
            @Valid @RequestBody Map<String, Object> params) {
        // 오늘의 스탬프를 수정하는 것으로 생각함.
        LocalDate today = LocalDate.now();
        return kakaoService.getValidatetHashMap(
                kakaoService.validateStampByTime(
                        params.get("kakaoId").toString(),
                        params.get("utterance").toString(),
                        today));
    }
}
