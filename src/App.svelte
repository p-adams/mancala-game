<script lang="ts">
  import { onMount } from "svelte";
  import { init } from "../game_protocol";
  let socket: WebSocket = null;
  let gameBoard = null;
  onMount(() => {
    // TODO: migrate protocol to svelte store
    socket = init({ port: "7001", url: "game" });
    socket.onmessage = (e) => {
      gameBoard = JSON.parse(e.data);
    };
  });
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
            socket.send(
              JSON.stringify({ p1Name: "Fred", p2Name: "#Guest123" })
            )}>start</button
        >
      </header>
      <article class="game-board">
        <div class="mancala_b" />
        <div class="pit-wrapper">
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
          <div class="pit" />
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
