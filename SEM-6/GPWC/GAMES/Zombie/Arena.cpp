#include <SFML/Graphics.hpp>
using namespace sf;
int createBackground(VertexArray& rVA, IntRect arena);

int createBackground(VertexArray& rVA, IntRect arena) {
	const int TILE_SIZE = 50;
	const int TILE_TYPES = 3;
	const int VERTS_IN_QUAD = 4;
	
	int worldWidth = arena.width/TILE_SIZE;
	int worldHeight = arena.height/TILE_SIZE;
	
	rVA.setPrimitiveType(Quads);
	rVA.resize(worldHeight * worldWidth * VERTS_IN_QUAD);
	int currentVertex = 0;
	
	for(int w = 0; w < worldWidth; w++) {
		for(int h = 0; h < worldHeight; h++) {
			
		}
	}
	
	return TILE_SIZE;
}

int main() {
	return 0;
}