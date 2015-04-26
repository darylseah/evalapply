PAPER = report
DVIPS_FLAGS = -t a4

all:	$(PAPER).tex $(PAPER).bib
	latex $(PAPER).tex
	bibtex $(PAPER)
	latex $(PAPER).tex
	dvips $(DVIPS_FLAGS) -o $(PAPER).ps $(PAPER)
	ps2pdf -dEmbedAllFonts=true -dUseFlateCompression=true -dOptimize=true -dCompatibilityLevel=1.2 $(PAPER).ps

clean:
	rm *.ps *.pdf $(PAPER).log $(PAPER).bbl $(PAPER).toc $(PAPER).blg $(PAPER).dvi $(PAPER).aux *~
