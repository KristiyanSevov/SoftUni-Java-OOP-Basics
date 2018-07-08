package interfaces;

public interface Manager {
    String checkComicCharacter(String characterName);

	String addHero(ComicCharacter hero);

	String addAntiHero(ComicCharacter hero);

	String addArena(Arena arena);

	String addHeroToArena(String arena, String hero);

	String addAntiHeroToArena(String arena, String antiHero);

	String loadSuperPowerToPool(SuperPower superPower);

	String asignSuperPowerToComicCharacter(String comicCharacter,String superPower);

	String usePowers(String commandToken);

	String startBattle(String arena);

	String endWar();
}
