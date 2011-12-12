# nodelist

A simple notepad for an experiment with local shell scripting
over SSH using pallet and my macbook.

## Usage

* Make sure you have a spare account that can be ssh:ed into
* Change the ACCOUNT def in src/nodelist/core.clj to match
* lein run
* change local-files/example1.txt
* lein run

P.S.: If you want to run it using a REPL (like with swank and emacs), 
logs will end up in the "logs" directory.

## License

Copyright (C) 2011 Anyone

Distributed under the Eclipse Public License, the same as Clojure.
