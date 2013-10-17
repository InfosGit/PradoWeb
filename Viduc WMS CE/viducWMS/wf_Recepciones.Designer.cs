namespace viducWMS
{
    partial class wf_Recepcion
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
            this.dgUbicaciones = new System.Windows.Forms.DataGrid();
            this.lblTitle = new System.Windows.Forms.Label();
            this.txtCodProducto = new System.Windows.Forms.TextBox();
            this.btnAgregarProducto = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtUnidadesRecibidas = new System.Windows.Forms.TextBox();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.txtFactura = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.nt_Recepcion = new Microsoft.WindowsCE.Forms.Notification();
            this.SuspendLayout();
            // 
            // dgUbicaciones
            // 
            this.dgUbicaciones.BackColor = System.Drawing.Color.White;
            this.dgUbicaciones.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgUbicaciones.Location = new System.Drawing.Point(6, 27);
            this.dgUbicaciones.Name = "dgUbicaciones";
            this.dgUbicaciones.Size = new System.Drawing.Size(228, 163);
            this.dgUbicaciones.TabIndex = 4;
            this.dgUbicaciones.KeyUp += new System.Windows.Forms.KeyEventHandler(this.dgUbicaciones_KeyUp);
            this.dgUbicaciones.Click += new System.EventHandler(this.dgUbicaciones_Click);
            // 
            // lblTitle
            // 
            this.lblTitle.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.lblTitle.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.lblTitle.ForeColor = System.Drawing.Color.Navy;
            this.lblTitle.Location = new System.Drawing.Point(4, 0);
            this.lblTitle.Name = "lblTitle";
            this.lblTitle.Size = new System.Drawing.Size(126, 14);
            this.lblTitle.Text = "Listado de productos";
            this.lblTitle.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // txtCodProducto
            // 
            this.txtCodProducto.BackColor = System.Drawing.Color.White;
            this.txtCodProducto.Location = new System.Drawing.Point(110, 216);
            this.txtCodProducto.Name = "txtCodProducto";
            this.txtCodProducto.Size = new System.Drawing.Size(125, 21);
            this.txtCodProducto.TabIndex = 0;
            this.txtCodProducto.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtCodProducto_KeyUp);
            // 
            // btnAgregarProducto
            // 
            this.btnAgregarProducto.BackColor = System.Drawing.Color.Navy;
            this.btnAgregarProducto.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnAgregarProducto.ForeColor = System.Drawing.Color.White;
            this.btnAgregarProducto.Location = new System.Drawing.Point(7, 263);
            this.btnAgregarProducto.Name = "btnAgregarProducto";
            this.btnAgregarProducto.Size = new System.Drawing.Size(93, 30);
            this.btnAgregarProducto.TabIndex = 2;
            this.btnAgregarProducto.Text = "Aceptar";
            this.btnAgregarProducto.Click += new System.EventHandler(this.btnAgregarProducto_Click);
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Navy;
            this.label1.Location = new System.Drawing.Point(17, 220);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 16);
            this.label1.Text = "Cód. Producto:";
            // 
            // label2
            // 
            this.label2.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label2.ForeColor = System.Drawing.Color.Navy;
            this.label2.Location = new System.Drawing.Point(20, 241);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 15);
            this.label2.Text = "Uni. recibidas:";
            // 
            // txtUnidadesRecibidas
            // 
            this.txtUnidadesRecibidas.BackColor = System.Drawing.Color.White;
            this.txtUnidadesRecibidas.Location = new System.Drawing.Point(110, 238);
            this.txtUnidadesRecibidas.Name = "txtUnidadesRecibidas";
            this.txtUnidadesRecibidas.Size = new System.Drawing.Size(125, 21);
            this.txtUnidadesRecibidas.TabIndex = 1;
            this.txtUnidadesRecibidas.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtUnidadesRecibidas_KeyUp);
            // 
            // btnCancelar
            // 
            this.btnCancelar.BackColor = System.Drawing.Color.Navy;
            this.btnCancelar.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnCancelar.ForeColor = System.Drawing.Color.White;
            this.btnCancelar.Location = new System.Drawing.Point(142, 263);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(93, 30);
            this.btnCancelar.TabIndex = 3;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // txtFactura
            // 
            this.txtFactura.BackColor = System.Drawing.Color.White;
            this.txtFactura.Location = new System.Drawing.Point(110, 194);
            this.txtFactura.Name = "txtFactura";
            this.txtFactura.Size = new System.Drawing.Size(125, 21);
            this.txtFactura.TabIndex = 7;
            this.txtFactura.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtFactura_KeyUp);
            // 
            // label3
            // 
            this.label3.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label3.ForeColor = System.Drawing.Color.Navy;
            this.label3.Location = new System.Drawing.Point(4, 198);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(100, 15);
            this.label3.Text = "Número Factura:";
            // 
            // nt_Recepcion
            // 
            this.nt_Recepcion.Caption = "";
            this.nt_Recepcion.InitialDuration = 0;
            this.nt_Recepcion.Text = "";
            // 
            // wf_Recepcion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtFactura);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.txtUnidadesRecibidas);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnAgregarProducto);
            this.Controls.Add(this.txtCodProducto);
            this.Controls.Add(this.lblTitle);
            this.Controls.Add(this.dgUbicaciones);
            this.KeyPreview = true;
            this.Name = "wf_Recepcion";
            this.Text = "Recepción de productos";
            this.Load += new System.EventHandler(this.wf_Recepcion_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGrid dgUbicaciones;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.TextBox txtCodProducto;
        private System.Windows.Forms.Button btnAgregarProducto;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtUnidadesRecibidas;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.TextBox txtFactura;
        private System.Windows.Forms.Label label3;
        private Microsoft.WindowsCE.Forms.Notification nt_Recepcion;
    }
}