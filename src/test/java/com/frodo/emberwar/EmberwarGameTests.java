package com.frodo.emberwar;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.domain.Position;
import com.frodo.emberwar.application.spi.WorldLoaderPort;
import com.frodo.emberwar.application.spi.WorldSource;
import com.frodo.emberwar.infrastructure.out.file.JsonWorldLoader;
import com.frodo.emberwar.infrastructure.out.file.JsonWorldSource;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmberwarGameTests {

	@Test
	void createAGameWorldFromJson() {
		ObjectMapper mapper = new ObjectMapper();
		WorldLoaderPort loader = new JsonWorldLoader(mapper);

		// Wrap the JSON file in a WorldSource
		WorldSource source = new JsonWorldSource();

		GameWorld world = loader.loadWorld();

		assertNotNull(world);
		assertNotNull(world.getMap());
		assertNotNull(world.getMap().tileAt(new Position(0, 0)));

		assertFalse(world.getUnits().isEmpty());
	}


}
