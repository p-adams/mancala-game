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
  $: p1Store = message?.data?.board.p1Store;

  $: p2Store = message?.data?.board.p2Store;

  $: board = message?.data?.board;

  $: pits = () => {
    if (!message?.data?.board?.pits) return [];
    const [p1Row, p2Row] = message?.data?.board.pits;
    // display player 1 row on bottom; player two on top reversed
    return [[...p2Row].reverse(), p1Row].flat();
  };
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
        <div class="mancala_b" />

        <div class="pit-wrapper">
          {#each pits() as pit}
            <div class="pit">{pit.label}</div>
          {/each}
        </div>
        <div class="mancala_a" />
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

  .pit-wrapper {
    width: 100%;
    display: grid;
    grid-template-columns: repeat(6, 1fr);
    grid-template-rows: repeat(2, 1fr);
  }
  .pit {
    border: 1px solid red;
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
