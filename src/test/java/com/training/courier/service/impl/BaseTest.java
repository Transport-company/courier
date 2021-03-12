package com.training.courier.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.quality.Strictness;

public class BaseTest {

    private MockitoSession mockitoSession;

    @BeforeEach
    void initMocks() {
        mockitoSession = Mockito.mockitoSession()
                .initMocks(this)
                .strictness(Strictness.STRICT_STUBS)
                .startMocking();
    }

    @AfterEach
    void finishMocking() {
        mockitoSession.finishMocking();
    }
}
