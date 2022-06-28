<script lang="ts">
  import { afterUpdate, onMount } from "svelte";
  import { init } from "../protocol/socket";
  import { SocketMessage, processMessage } from "../protocol/message";

  let socket: WebSocket = null;
  let message: SocketMessage = null;

  const socketData = (data): SocketMessage => JSON.parse(data);

  const sendMessage = (payload) => socket.send(JSON.stringify(payload));
  onMount(() => {
    // TODO: migrate protocol to svelte store
    socket = init({ port: "7001", url: "game" });
  });
  afterUpdate(() => {
    socket.onmessage = (msgEvt) => {
      const data = socketData(msgEvt.data);
      message = processMessage(data.messageType, data);
    };
  });

  // TODO: move reactive declarations to Svelte store
  $: p1Store = message?.data?.board?.p1Store;

  $: p2Store = message?.data?.board?.p2Store;

  $: board = message?.data?.board;

  $: pits = () => {
    if (!message?.data?.board?.pits) return [];
    const [p1Row, p2Row] = message?.data?.board.pits;
    const p1BoardView = [[...p2Row].reverse(), p1Row].flat();
    // TODO: conditionally return board view based on player 1/2
    const p2BoardView = [[...p1Row].reverse(), p2Row].flat();
    return p1BoardView;
  };

  function pickupStones(label: string) {
    sendMessage({
      messageType: "PICKUP_STONES",
      data: {
        colId: label,
        player: "",
      },
    });
  }
  function dropStone(label: string) {
    console.log(`drop stone in column: ${label}`);
  }
</script>

<header>
  <h3>Mancala</h3>
</header>
<main>
  <article>
    <section class="main-section">
      <header>
        <button
          on:click={() =>
            sendMessage({
              messageType: "START_GAME",
              data: {
                p1Name: "Fred",
                p2Name: "#Guest123",
                board,
              },
            })}>start</button
        >
      </header>

      <article class="game-board">
        <div class="mancala_b">
          <div class="Pit-label">
            {p2Store?.label ?? "P2 Store"}
          </div>
          <div class="Pit Store">pit</div>
        </div>

        <div class="Pit-grid">
          {#each pits() as pit}
            <div class="Pit-wrapper">
              <div class="Pit-label">
                {pit.label}
              </div>
              <div class="Pit">
                <div class="Stone-wrapper">
                  {#each pit.stones as stone}
                    <div
                      class="Stone"
                      on:dblclick={() => pickupStones(pit.label)}
                      on:click={() => dropStone(pit.label)}
                    />
                  {/each}
                </div>
              </div>
            </div>
          {/each}
        </div>
        <div class="mancala_a">
          <div class="Pit-label">
            {p1Store?.label ?? "P1 Store"}
          </div>
          <div class="Pit store">pit</div>
        </div>
      </article>
      <details>
        <summary>Game Rules</summary>
        <p>game rules here</p>
      </details>
    </section>
  </article>
</main>
<footer />

<style>
  :root {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
      Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
    --Pit-label-h: 18px;
  }

  main {
    text-align: center;
    padding: 1em;
    margin: 0 auto;
  }

  .game-board {
    display: flex;
    justify-content: space-between;
    height: 500px;
    width: 90%;
    border: 1px solid black;
    margin: 10px 0 10px 0;
  }

  .mancala_a,
  .mancala_b {
    border: 1px solid blue;
    width: 25%;
  }

  .Pit-grid {
    width: 100%;
    display: grid;
    grid-template-columns: repeat(6, 100px);
    grid-template-rows: repeat(2, 1fr);
    gap: 10px;
    margin: 0 10px 0 10px;
  }
  .Pit-wrapper {
    border: 1px solid rgb(182, 83, 83);
  }
  .Pit {
    height: calc(100% - var(--Pit-label-h));
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: rgb(182, 83, 83);
  }
  .Pit-label {
    color: blue;
    height: var(--Pit-label-h);
  }
  .Pit.Store {
    height: calc(100% - var(--Pit-label-h));
  }
  .Stone-wrapper {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    flex-wrap: wrap;
    height: calc(100% - var(--Pit-label-h) - 120px);
    width: 90%;
    padding: 4px;
    background-color: black;
    border-radius: 50%;
  }
  .Stone {
    width: 30px;
    height: 30px;
    border-radius: 50%;
    padding: px;
    background-color: green;
  }
  .main-section {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  @media (min-width: 480px) {
    h3 {
      max-width: none;
    }
  }
</style>
