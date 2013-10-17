namespace viducWMS
{
    partial class wf_DespachoProducto
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.dgProformaProducto = new System.Windows.Forms.DataGrid();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.txtDescripcion = new System.Windows.Forms.TextBox();
            this.txtCodProducto = new System.Windows.Forms.TextBox();
            this.lblProdcto = new System.Windows.Forms.Label();
            this.chkSeleccioneTodos = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // dgProformaProducto
            // 
            this.dgProformaProducto.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgProformaProducto.Location = new System.Drawing.Point(4, 34);
            this.dgProformaProducto.Name = "dgProformaProducto";
            this.dgProformaProducto.Size = new System.Drawing.Size(231, 178);
            this.dgProformaProducto.TabIndex = 3;
            this.dgProformaProducto.DoubleClick += new System.EventHandler(this.dgProformaProducto_DoubleClick);
            this.dgProformaProducto.KeyUp += new System.Windows.Forms.KeyEventHandler(this.dgProformaProducto_KeyUp);
            this.dgProformaProducto.Click += new System.EventHandler(this.dgProformaProducto_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.BackColor = System.Drawing.Color.Navy;
            this.btnCancelar.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnCancelar.ForeColor = System.Drawing.Color.White;
            this.btnCancelar.Location = new System.Drawing.Point(143, 262);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(91, 30);
            this.btnCancelar.TabIndex = 3;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // txtDescripcion
            // 
            this.txtDescripcion.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.txtDescripcion.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.txtDescripcion.Location = new System.Drawing.Point(6, 3);
            this.txtDescripcion.Multiline = true;
            this.txtDescripcion.Name = "txtDescripcion";
            this.txtDescripcion.ReadOnly = true;
            this.txtDescripcion.Size = new System.Drawing.Size(228, 27);
            this.txtDescripcion.TabIndex = 21;
            // 
            // txtCodProducto
            // 
            this.txtCodProducto.Location = new System.Drawing.Point(4, 228);
            this.txtCodProducto.Multiline = true;
            this.txtCodProducto.Name = "txtCodProducto";
            this.txtCodProducto.ReadOnly = true;
            this.txtCodProducto.Size = new System.Drawing.Size(231, 31);
            this.txtCodProducto.TabIndex = 0;
            this.txtCodProducto.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtCodProducto_KeyUp);
            // 
            // lblProdcto
            // 
            this.lblProdcto.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.lblProdcto.ForeColor = System.Drawing.Color.Navy;
            this.lblProdcto.Location = new System.Drawing.Point(4, 213);
            this.lblProdcto.Name = "lblProdcto";
            this.lblProdcto.Size = new System.Drawing.Size(62, 11);
            this.lblProdcto.Text = "Producto:";
            // 
            // chkSeleccioneTodos
            // 
            this.chkSeleccioneTodos.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.chkSeleccioneTodos.ForeColor = System.Drawing.Color.Navy;
            this.chkSeleccioneTodos.Location = new System.Drawing.Point(2, 268);
            this.chkSeleccioneTodos.Name = "chkSeleccioneTodos";
            this.chkSeleccioneTodos.Size = new System.Drawing.Size(137, 15);
            this.chkSeleccioneTodos.TabIndex = 22;
            this.chkSeleccioneTodos.Text = "Todos los productos";
            this.chkSeleccioneTodos.Visible = false;
            this.chkSeleccioneTodos.Click += new System.EventHandler(this.chkSeleccioneTodos_Click);
            // 
            // wf_DespachoProducto
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.chkSeleccioneTodos);
            this.Controls.Add(this.lblProdcto);
            this.Controls.Add(this.txtCodProducto);
            this.Controls.Add(this.txtDescripcion);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.dgProformaProducto);
            this.KeyPreview = true;
            this.Name = "wf_DespachoProducto";
            this.Text = "Despacho de producto";
            this.Load += new System.EventHandler(this.wf_DespachoProducto_Load);
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.wf_DespachoProducto_KeyDown);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGrid dgProformaProducto;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.TextBox txtDescripcion;
        private System.Windows.Forms.TextBox txtCodProducto;
        private System.Windows.Forms.Label lblProdcto;
        private System.Windows.Forms.CheckBox chkSeleccioneTodos;
    }
}