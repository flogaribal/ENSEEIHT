	.file	"mult_mat.c"
	.section	.rodata
	.align 8
.LC2:
	.string	"Temps multiplication %d secondes %d millisecondes\n"
.LC3:
	.string	"Erreur i: %d j: %d\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB2:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	subq	$64, %rsp
	.cfi_offset 14, -24
	.cfi_offset 13, -32
	.cfi_offset 12, -40
	.cfi_offset 3, -48
	movl	%edi, -84(%rbp)
	movq	%rsi, -96(%rbp)
	movl	$1000, %r12d
	cmpl	$1, -84(%rbp)
	jle	.L2
	movq	-96(%rbp), %rax
	addq	$8, %rax
	movq	(%rax), %rax
	movq	%rax, %rdi
	call	atoi
	movl	%eax, %r12d
.L2:
	movl	%r12d, %eax
	imull	%r12d, %eax
	cltq
	salq	$2, %rax
	movq	%rax, %rdi
	call	malloc
	movq	%rax, -48(%rbp)
	movl	%r12d, %eax
	imull	%r12d, %eax
	cltq
	salq	$2, %rax
	movq	%rax, %rdi
	call	malloc
	movq	%rax, -56(%rbp)
	movl	%r12d, %eax
	imull	%r12d, %eax
	cltq
	salq	$2, %rax
	movq	%rax, %rdi
	call	malloc
	movq	%rax, -64(%rbp)
	movl	$0, %ebx
	jmp	.L3
.L7:
	movl	$0, %r13d
	jmp	.L4
.L6:
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-48(%rbp), %rax
	addq	%rax, %rdx
	movl	.LC0(%rip), %eax
	movl	%eax, (%rdx)
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-56(%rbp), %rax
	addq	%rax, %rdx
	movl	.LC0(%rip), %eax
	movl	%eax, (%rdx)
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-64(%rbp), %rax
	addq	%rax, %rdx
	movl	.LC1(%rip), %eax
	movl	%eax, (%rdx)
	cmpl	%r13d, %ebx
	jne	.L5
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-48(%rbp), %rax
	addq	%rax, %rdx
	leal	1(%rbx), %eax
	pxor	%xmm2, %xmm2
	cvtsi2ss	%eax, %xmm2
	movd	%xmm2, %eax
	movl	%eax, (%rdx)
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-56(%rbp), %rax
	addq	%rax, %rdx
	leal	1(%rbx), %eax
	pxor	%xmm3, %xmm3
	cvtsi2ss	%eax, %xmm3
	movd	%xmm3, %eax
	movl	%eax, (%rdx)
.L5:
	addl	$1, %r13d
.L4:
	cmpl	%r12d, %r13d
	jl	.L6
	addl	$1, %ebx
.L3:
	cmpl	%r12d, %ebx
	jl	.L7
	call	clock
	movq	%rax, -72(%rbp)
	movl	$0, %ebx
	jmp	.L8
.L13:
	movl	$0, %r13d
	jmp	.L9
.L12:
	movl	.LC1(%rip), %eax
	movl	%eax, -36(%rbp)
	movl	$0, %r14d
	jmp	.L10
.L11:
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r14d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-48(%rbp), %rax
	addq	%rdx, %rax
	movss	(%rax), %xmm1
	movl	%r14d, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-56(%rbp), %rax
	addq	%rdx, %rax
	movss	(%rax), %xmm0
	mulss	%xmm1, %xmm0
	movss	-36(%rbp), %xmm1
	addss	%xmm0, %xmm1
	movd	%xmm1, %eax
	movl	%eax, -36(%rbp)
	addl	$1, %r14d
.L10:
	cmpl	%r12d, %r14d
	jl	.L11
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-64(%rbp), %rax
	addq	%rax, %rdx
	movl	-36(%rbp), %eax
	movl	%eax, (%rdx)
	addl	$1, %r13d
.L9:
	cmpl	%r12d, %r13d
	jl	.L12
	addl	$1, %ebx
.L8:
	cmpl	%r12d, %ebx
	jl	.L13
	call	clock
	subq	-72(%rbp), %rax
	movq	%rax, -80(%rbp)
	movq	-80(%rbp), %rax
	imulq	$1000, %rax, %rcx
	movabsq	$4835703278458516699, %rdx
	movq	%rcx, %rax
	imulq	%rdx
	sarq	$18, %rdx
	movq	%rcx, %rax
	sarq	$63, %rax
	subq	%rax, %rdx
	movq	%rdx, %rax
	movl	%eax, %ebx
	movl	$274877907, %edx
	movl	%ebx, %eax
	imull	%edx
	sarl	$6, %edx
	movl	%ebx, %eax
	sarl	$31, %eax
	movl	%edx, %ecx
	subl	%eax, %ecx
	imull	$1000, %ecx, %eax
	movl	%ebx, %ecx
	subl	%eax, %ecx
	movl	$274877907, %edx
	movl	%ebx, %eax
	imull	%edx
	sarl	$6, %edx
	movl	%ebx, %eax
	sarl	$31, %eax
	subl	%eax, %edx
	movl	%edx, %eax
	movl	%ecx, %edx
	movl	%eax, %esi
	movl	$.LC2, %edi
	movl	$0, %eax
	call	printf
	movl	$0, %ebx
	jmp	.L14
.L21:
	movl	$0, %r13d
	jmp	.L15
.L20:
	cmpl	%r13d, %ebx
	jne	.L16
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-64(%rbp), %rax
	addq	%rdx, %rax
	movss	(%rax), %xmm1
	leal	1(%rbx), %edx
	leal	1(%rbx), %eax
	imull	%edx, %eax
	addl	%r12d, %eax
	subl	$1, %eax
	pxor	%xmm0, %xmm0
	cvtsi2ss	%eax, %xmm0
	ucomiss	%xmm0, %xmm1
	jp	.L23
	ucomiss	%xmm0, %xmm1
	je	.L16
.L23:
	movl	%r13d, %edx
	movl	%ebx, %esi
	movl	$.LC3, %edi
	movl	$0, %eax
	call	printf
	jmp	.L18
.L16:
	cmpl	%r13d, %ebx
	je	.L18
	movl	%ebx, %eax
	imull	%r12d, %eax
	addl	%r13d, %eax
	cltq
	leaq	0(,%rax,4), %rdx
	movq	-64(%rbp), %rax
	addq	%rdx, %rax
	movss	(%rax), %xmm1
	leal	(%rbx,%r13), %eax
	addl	%r12d, %eax
	pxor	%xmm0, %xmm0
	cvtsi2ss	%eax, %xmm0
	ucomiss	%xmm0, %xmm1
	jp	.L24
	ucomiss	%xmm0, %xmm1
	je	.L18
.L24:
	movl	%r13d, %edx
	movl	%ebx, %esi
	movl	$.LC3, %edi
	movl	$0, %eax
	call	printf
.L18:
	addl	$1, %r13d
.L15:
	cmpl	%r12d, %r13d
	jl	.L20
	addl	$1, %ebx
.L14:
	cmpl	%r12d, %ebx
	jl	.L21
	movq	-48(%rbp), %rax
	movq	%rax, %rdi
	call	free
	movq	-56(%rbp), %rax
	movq	%rax, %rdi
	call	free
	movq	-64(%rbp), %rax
	movq	%rax, %rdi
	call	free
	movl	$0, %eax
	addq	$64, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2:
	.size	main, .-main
	.section	.rodata
	.align 4
.LC0:
	.long	1065353216
	.align 4
.LC1:
	.long	0
	.ident	"GCC: (Debian 4.9.2-10) 4.9.2"
	.section	.note.GNU-stack,"",@progbits
