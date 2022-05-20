<script lang="ts">
</script>

<header>
  <h3>Mancala</h3>
</header>
<main>
  <article>
    <section>
      <div class="game-board">
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
      </div>
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
