# Angular Universal

[Documentation](https://angular.io/guide/universal)

## HelloSSR

Commands:

	ng new helloSSR
	cd helloSSR
	ng add @nguniversal/express-engine
	npm run dev:ssr

Use Firefox/Chrome Throttling (Regular 3G) to verify the diferences between npm start | npm run dev:ssr

Generate bundle:

	ng run helloSSR:server

	or

	npm run build:ssr

## Features

- Pages are pure HTML
- Works even with JavaScript disabled
- routerLink works!
- Browser events does not works!

## product

	ng new product
	cd product
	ng add @nguniversal/express-engine

## Error

Fix issue: Error: Uncaught (in promise): ReferenceError: localStorage is not defined

	npm install localstorage-polyfill

Add below code to server.ts

	import 'localstorage-polyfill';
	global['localStorage'] = localStorage;

Rebuild 

	npm run build:ssr

Run

	npm run serve:ssr

	










