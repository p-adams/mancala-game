<script lang="ts">
  import { onMount } from "svelte";

  import { init } from "../socket";
  let socket: WebSocket = null;
  onMount(() => {
    // TODO: migrate protocol to svelte store
    socket = init({ port: "7001", url: "game" });
    socket.onmessage = (e) => {
      console.log(e.data);
      socket.send("start");
    };
  });
</script>

<header>
  <h3>Mancala</h3>
</header>
<main>
  <article>
    <section>
      <header>
        <button on:click={() => socket.send("start")}>start</button>
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
    width: 700px;
    border: 1px solid black;
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

  @media (min-width: 480px) {
    h3 {
      max-width: none;
    }
  }
</style>
