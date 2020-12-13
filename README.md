# Mastermind Clojure Pairing Group at The Recurse Center

This is an attempt to implement the [Mastermind code breaking game][mastermind]
via pair programming in Clojure with friends at [Recurse Center][recurse].

For pair programming, we're using:

- tmate (hi-res terminal sharing)
- Zoom (audio/video)
- vim with fireplace for quasi-repl and file eval
- `lein repl` for nrepl server
- `tail -f .lein-repl-history` for copy/pasting the history
- tmux for split pane

Here's a screenshot of how it looks:

![screenshot](https://user-images.githubusercontent.com/40263/102014924-85eebf80-3d26-11eb-8839-18befbf0e710.png)

The **left-hand side** here shows a tmux pane with vim running, and the
quasi-repl command buffer from vim-fireplace at the bottom (accessible via
`cqc`). You can evaluate the module using `cpr` and you can evaluate any
expression under a cursor using `cpp`. For reference, you can use this [nice
hotkey cheat sheet covering fireplace and paredit][cheat-sheet].

The **right-hand side** is two panes.

The **top-right pane** is simply `lein
repl`.  You can evaluate expressions there, and the effects of any expressions
evaluated in vim will be visible there, since they are sharing the same `nrepl`
connection.

The **bottom-right pane** is nothing more than `tail -f .lein-repl-history`. This
helps to just see the expressions (especially multi-line expressions) in plain
text, so they can be copy-pasted back into vim using tmux clipboard control.

Since this is part of a book club, we're using concepts from ["The Joy of
Clojure"][joy] (Manning Press) and "The Elements of Clojure" in writing our code.

Ironically, though we are implementing Mastermind, the board game, these
pairing sessions also serve as ["mastermind group"][group] for a few
professional programmers expanding their functional programming horizons beyond
the usual concepts found in languages like Python and JavaScript.

[cheat-sheet]: https://gist.github.com/nblumoe/5450099
[joy]: https://amzn.to/2LyNZmL
[recurse]: https://recurse.com
[mastermind]: https://en.wikipedia.org/wiki/Mastermind_(board_game)
[group]: https://en.wikipedia.org/wiki/Mastermind_group
