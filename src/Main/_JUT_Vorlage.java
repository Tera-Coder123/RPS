package Main;

import static org.junit.jupiter.api.Assertions.*;

import Figure.Goal;
import Figure.GoalManager;
import GUI.MainFrame;
import GUI.Playground;
import Map.Grid;
import org.junit.jupiter.api.*;


/****************************************************************************************************
 * 
 * JUnit Test
 *
 * @author von: Prof. Gaisberger
 * @author genutzt: Maximilian Raidl
 * @date 10.11.2020 / admin
 *
 ****************************************************************************************************
 **/


@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//---------------------------------------------------------------------------------------------------
class _JUT_Vorlage
{
	@Test
	@Order(10)
	@DisplayName("Not loaded Array")
	void test1()
	{
		Throwable exeption = assertThrows(NullPointerException.class, () -> Grid.getBoxes()[0][0].setX(10));
		assertEquals("Cannot load from object array because the return value of \"Map.Grid.getBoxes()\" is null", exeption.getMessage());
	}

	@Test
	@Order(20)
	@DisplayName("Name of the Game")
	void test2()
	{
		Game game = new Game();

		String name = "RSP";
		game.setName(name);

		assertEquals(name,game.getName(),"Name must be the same as set");
	}

	@Test
	@Order(30)
	@DisplayName("Description of the Game")
	void test3()
	{
		Game game = new Game();

		String description = "A Small game.";
		game.setDescription(description);

		assertEquals(description,game.getDescription(),"Description must be the same as set");
	}

	@Test
	@Order(40)
	@DisplayName("Author of the Game")
	void test4()
	{
		Game game = new Game();

		String author = "Maximilian Raidl";
		game.setAuthor(author);

		assertEquals(author,game.getAuthor(),"Author must be the same as set");
	}
}
