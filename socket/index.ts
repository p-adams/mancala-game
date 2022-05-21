interface SocketConfigOptions {
  port: string;
  url: string;
}
export function init({ port, url }: SocketConfigOptions) {
  return new WebSocket(`ws://localhost:${port}/${url}`);
}
