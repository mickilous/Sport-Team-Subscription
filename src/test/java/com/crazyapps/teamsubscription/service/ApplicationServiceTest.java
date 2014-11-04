package com.crazyapps.teamsubscription.service;

import static com.crazyapps.teamsubscription.data.DataProvider.newPilot;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crazyapps.teamsubscription.model.Pilot;
import com.crazyapps.teamsubscription.repository.PilotRepository;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {

	@InjectMocks
	ApplicationService applicationService = new ApplicationServiceImpl();

	@Mock
	PilotRepository pilotRepository;

	@Test
	public void testCreateUser() {

		Pilot pilot = newPilot();

		when(pilotRepository.save(any(Pilot.class))).thenReturn(pilot);

		pilot = applicationService.createPilot(pilot.getEmail(), pilot.getFbId(), pilot.getAvatar(), pilot.getNationality());

		assertNotNull(pilot);

		verify(pilotRepository).save(pilot);

	}

}
