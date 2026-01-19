package com.frodo.emberwar;

import com.frodo.emberwar.domain.GameWorld;
import com.frodo.emberwar.domain.Position;
import com.frodo.emberwar.domain.spi.WorldLoaderPort;
import com.frodo.emberwar.domain.spi.WorldSource;
import com.frodo.emberwar.infrastructure.json.JsonWorldLoader;
import com.frodo.emberwar.infrastructure.world.JsonWorldSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmberwarGameTests {

	@Test
	void createAGameWorldFromJson() {
		ObjectMapper mapper = new ObjectMapper();
		WorldLoaderPort loader = new JsonWorldLoader(mapper);

		// Wrap the JSON file in a WorldSource
		WorldSource source = new JsonWorldSource("gameworld.json");

		GameWorld world = loader.loadWorld(source);

		assertNotNull(world);
		assertNotNull(world.getMap());
		assertNotNull(world.getMap().tileAt(new Position(0, 0)));

		assertFalse(world.getUnits().isEmpty());
	}


}
