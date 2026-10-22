# SmartFlow — Smart Traffic Signal Management

A student-friendly website and Java console simulation based on the abstract **Smart Traffic Signal Management and Emergency Vehicle Prioritization**.

## Project features
- Four-way intersection: North, South, East, and West.
- Visual traffic lights and waiting-vehicle counts.
- Add vehicles to each road and watch queue sizes change.
- Adaptive timing chooses the busier pair of roads.
- Emergency priority mode for a selected approach.
- Processed-vehicle count, estimated waiting indicator, and activity log.
- Java example demonstrates FIFO queues, a priority queue, and queue-based phase selection.

## Files
- `index.html` — webpage structure.
- `style.css` — layout, colors, and responsive design.
- `script.js` — interactive browser simulation.
- `TrafficSimulation.java` — Java console demonstration.
- `README.md` — setup and usage notes.

## Run the website
1. Extract the ZIP file.
2. Open `index.html` in Chrome, Edge, or Firefox.
3. Click **Run simulation** to run automatically.
4. Use **Process one signal phase** for a single step.
5. Use the **+ Add** buttons to add vehicles to each road.
6. Turn on **Emergency vehicle** and choose the approach to demonstrate priority.
7. Click **Reset demo** to restore the initial state.

No npm install or external JavaScript libraries are required. Google Fonts are used if internet access is available; the site still works without them.

## Run the Java demonstration
Install a JDK (Java 8 or later), open a terminal in this folder, then run:

```bash
javac TrafficSimulation.java
java TrafficSimulation
```

The Java console model is a companion demonstration of the data structures. The live visual website uses JavaScript in the browser; the Java program runs separately.

## Data structures shown
- **Queue (FIFO):** vehicles are processed in arrival order on each road.
- **Priority queue:** an emergency vehicle request is represented with a priority value.
- **HashMap/Map:** road names are mapped to their queues.
- **Adaptive scheduling:** the road pair with the larger combined queue is selected for the next phase.

## Important limitation
This is an educational simulation only. It is not clinically or operationally validated and must not be connected to real traffic signals. Its vehicle counts, waiting estimates, and signal logic are illustrative.
