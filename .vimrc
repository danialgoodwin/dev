"Use the key combo `j, k` as escape
imap jk <esc>

if $diff
  set number
  syntax off
endif

"Move vertically by visual line
nnoremap j gj
nnoremap k gk
