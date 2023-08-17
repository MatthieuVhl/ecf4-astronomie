package com.example.celesteservice;

import com.example.celesteservice.entity.Celeste;
import com.example.celesteservice.repository.CelesteRepository;
import com.example.celesteservice.service.CelesteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class CelesteServiceApplicationTests {

    @Mock
    private CelesteRepository celesteRepository;
    @InjectMocks
    private CelesteService celesteService;
    @Test
    public void shouldAddNewCelesteWhenValidDataProvided()  {
        Celeste celeste = new Celeste(1,41,"test1","11111","11111");
        Mockito.when(celesteRepository.save(celeste)).thenReturn(celeste);

        Celeste result = celesteService.createCeleste(41,"111","test1","154545");
        Assertions.assertEquals(celeste, result);
    }

}
