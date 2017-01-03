
filetype plugin indent on
syntax on

set nocompatible
"set writebackup nobackup updatetime=1000 updatecount=50
set noignorecase
set autoindent
set shiftwidth=2 shiftround
set noexpandtab 
set showmode showcmd
set ruler
set report=0
set undolevels=1000
set backspace=indent,eol,start
set sidescroll=1
set wildchar=<Tab>
set joinspaces
set whichwrap=b,s,h,l,<,>,~,[,]
"
set errorformat=%f:%l:\ %m
" si on positionne textwidth à 0 il n' y a pas de retour à la ligne inséré
" automatiquement !
set textwidth=0
"
set comments=nsr:(*,nmb:**,nel:*),nb:#,n:%,:XCOMM,n:>,nfb:-,nbf:+,nbf:?,nbf:.,nbf:==>,nbf:=>,nbf:->,nbf:-->,n:--,nfb:o,nfb:[1-9][0-9.-)]*
set formatoptions=tclq
"
"
let g:ada_standard_types=1  " Colorie les types Ada.
let g:ada_line_errors=1  " Affiche les lignes trop longues
