	.file	"add_vect.c"
	.section	.rodata.str1.1,"aMS",@progbits,1
.LC3:
	.string	" %f "
	.section	.rodata.str1.8,"aMS",@progbits,1
	.align 8
.LC4:
	.string	" Temps d'execution %d secondes %d millisecondes \n"
	.section	.text.unlikely,"ax",@progbits
.LCOLDB5:
	.section	.text.startup,"ax",@progbits
.LHOTB5:
	.p2align 4,,15
	.globl	main
	.type	main, @function
main:
.LFB21:
	.cfi_startproc
	pushq	%r12
	.cfi_def_cfa_offset 16
	.cfi_offset 12, -16
	pushq	%rbp
	.cfi_def_cfa_offset 24
	.cfi_offset 6, -24
	xorl	%eax, %eax
	pushq	%rbx
	.cfi_def_cfa_offset 32
	.cfi_offset 3, -32
	subq	$800, %rsp
	.cfi_def_cfa_offset 832
	movdqa	.LC1(%rip), %xmm3
	movdqa	.LC0(%rip), %xmm0
	movaps	.LC2(%rip), %xmm2
	.p2align 4,,10
	.p2align 3
.L2:
	cvtdq2ps	%xmm0, %xmm1
	paddd	%xmm3, %xmm0
	movaps	%xmm1, (%rsp,%rax)
	movaps	%xmm2, 400(%rsp,%rax)
	addq	$16, %rax
	cmpq	$400, %rax
	jne	.L2
	call	clock
	movl	$20000000, %ecx
	movq	%rax, %rbp
	.p2align 4,,10
	.p2align 3
.L3:
	xorl	%edx, %edx
	.p2align 4,,10
	.p2align 3
.L4:
	movaps	(%rsp,%rdx), %xmm0
	addps	400(%rsp,%rdx), %xmm0
	movaps	%xmm0, (%rsp,%rdx)
	addq	$16, %rdx
	cmpq	$400, %rdx
	jne	.L4
	subl	$1, %ecx
	jne	.L3
	leaq	400(%rsp), %r12
	movq	%rsp, %rbx
.L6:
	pxor	%xmm0, %xmm0
	movl	$.LC3, %edi
	movl	$1, %eax
	addq	$40, %rbx
	cvtss2sd	-40(%rbx), %xmm0
	call	printf
	cmpq	%r12, %rbx
	jne	.L6
	movl	$10, %edi
	call	putchar
	call	clock
	movabsq	$2361183241434822607, %rdx
	subq	%rbp, %rax
	movl	$.LC4, %edi
	movq	%rax, %rcx
	imulq	%rdx
	sarq	$63, %rcx
	sarq	$7, %rdx
	subq	%rcx, %rdx
	movq	%rdx, %rcx
	movl	$274877907, %edx
	movl	%ecx, %eax
	mull	%edx
	movl	%edx, %esi
	movl	%ecx, %edx
	shrl	$6, %esi
	imull	$1000, %esi, %eax
	subl	%eax, %edx
	xorl	%eax, %eax
	call	printf
	addq	$800, %rsp
	.cfi_def_cfa_offset 32
	xorl	%eax, %eax
	popq	%rbx
	.cfi_def_cfa_offset 24
	popq	%rbp
	.cfi_def_cfa_offset 16
	popq	%r12
	.cfi_def_cfa_offset 8
	ret
	.cfi_endproc
.LFE21:
	.size	main, .-main
	.section	.text.unlikely
.LCOLDE5:
	.section	.text.startup
.LHOTE5:
	.section	.rodata.cst16,"aM",@progbits,16
	.align 16
.LC0:
	.long	0
	.long	1
	.long	2
	.long	3
	.align 16
.LC1:
	.long	4
	.long	4
	.long	4
	.long	4
	.align 16
.LC2:
	.long	1010055512
	.long	1010055512
	.long	1010055512
	.long	1010055512
	.ident	"GCC: (Debian 4.9.2-10) 4.9.2"
	.section	.note.GNU-stack,"",@progbits
