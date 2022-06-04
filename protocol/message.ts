// TODO: convert to svelte store
type messageHandler = (data: any) => any;

function startGame(gameBoard) {
  console.log("game ", gameBoard);
}

const messageMap = new Map<string, messageHandler>();
messageMap.set("START_GAME", startGame);

export function processMessage(messageType: string, data: any) {
  try {
    const handler = messageMap.get(messageType);
    handler(data);
  } catch (error) {
    console.log("cannot process message");
  }
}
